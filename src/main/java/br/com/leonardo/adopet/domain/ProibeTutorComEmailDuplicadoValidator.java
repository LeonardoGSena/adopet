package br.com.leonardo.adopet.domain;

import br.com.leonardo.adopet.repository.TutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeTutorComEmailDuplicadoValidator implements Validator {

    private final TutorRepository tutorRepository;

    public ProibeTutorComEmailDuplicadoValidator(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return DadosCadastroTutor.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        DadosCadastroTutor request = (DadosCadastroTutor) target;
        Optional<Tutor> possivelTutor = tutorRepository.findByEmail(request.email());
        if (possivelTutor.isPresent()) {
            errors.rejectValue("email", null, "Já existe esse email no sistema");
        }
    }
}
