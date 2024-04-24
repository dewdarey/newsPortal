package kz.springproject.phoenix.service;

import kz.springproject.phoenix.dto.ApplicationDto;
import kz.springproject.phoenix.mapper.ApplicationMapper;
import kz.springproject.phoenix.model.Application;
import kz.springproject.phoenix.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    public List<ApplicationDto> getAllApplications() {
        return applicationMapper.toDtoList(applicationRepository.findAll());
    }

    public ApplicationDto getApplicationById(Long id) {
        return applicationMapper.toDto(applicationRepository.findById(id).orElse(null));
    }

    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = applicationMapper.toEntity(applicationDto);
        Application savedApplication = applicationRepository.save(application);
        return applicationMapper.toDto(savedApplication);
    }

    public ApplicationDto updateApplication(Long id, ApplicationDto applicationDto) {
        Application application = applicationRepository.findById(id).orElse(null);
        if (application != null) {
            applicationMapper.updateEntity(applicationDto, application);
            applicationRepository.save(application);
            return applicationMapper.toDto(application);
        }
        return null;
    }

    public boolean deleteApplication(Long id) {
        if (applicationRepository.existsById(id)) {
            applicationRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
