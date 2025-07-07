package com.practice.crud.application.usecase;

import com.practice.crud.domain.exception.NoUserFoundException;
import com.practice.crud.domain.exception.UserAlreadyExistsException;
import com.practice.crud.domain.exception.UserNotFoundException;
import com.practice.crud.domain.model.User;
import com.practice.crud.domain.port.input.UserService;
import com.practice.crud.domain.port.output.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetUserUseCase implements UserService {
    private final UserRepository userRepository;

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll()
                .switchIfEmpty(Flux.error(new NoUserFoundException()));
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("Usuario con ID " + id + " no existe")));
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.findByEmailAddress(user.getEmailAddress())
                .flatMap(existingUser -> Mono.error(new UserAlreadyExistsException(user.getEmailAddress())))
                .switchIfEmpty(userRepository.save(user))
                .cast(User.class);
    }

    @Override
    public Mono<User> updateUser(Long id, User user) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("No se encontró un usuario con el ID " + id)))
                .flatMap(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setRut(user.getRut());
                    existingUser.setDv(user.getDv());
                    existingUser.setBirthDate(user.getBirthDate());
                    existingUser.setEmailAddress(user.getEmailAddress());
                    existingUser.setPassword(user.getPassword());
                    return userRepository.save(existingUser);
                });
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("No se encontró un usuario con el ID " + id)))
                .flatMap(user -> userRepository.deleteById(id));
    }
}
