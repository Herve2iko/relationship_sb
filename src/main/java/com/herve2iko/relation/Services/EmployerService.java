package com.herve2iko.relation.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.herve2iko.relation.Entity.Employer;
import com.herve2iko.relation.Entity.Genre;
import com.herve2iko.relation.Repository.AgenceREpository;
import com.herve2iko.relation.Repository.DepartementRepository;
import com.herve2iko.relation.Repository.EmployerRepository;
import com.herve2iko.relation.RequestClass.EmployRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerService {

    @Autowired
    private final EmployerRepository employerRepository;

    @Autowired
    private final AgenceREpository agenceREpository;

    @Autowired
    private final DepartementRepository departementRepository;

    public List<Employer> allEmployer() {
        return employerRepository.findAll();
    }

    public Page<Employer> allEmployerpagina(int offset, int pageSize) {
        Page<Employer> depPaginates = employerRepository.findAll(PageRequest.of(offset, pageSize));
        return depPaginates;
    }

    public List<Employer> getEmployerDepartement(String nom) {
        return employerRepository.getByDepartementName(nom);
    }

    public Employer getOneEmployer(Long id) {
        Optional<Employer> empl = employerRepository.findById(id);
        if (!empl.isPresent()) {
            throw new IllegalStateException("Employer introuvable");
        }
        return empl.get();
    }

    public void deleteEmployer(Long id) {
        Optional<Employer> empl = employerRepository.findById(id);
        if (!empl.isPresent()) {
            throw new IllegalStateException("Employer introuvable");
        }
        employerRepository.delete(empl.get());
    }

    public EmployRequest saveEmployer(EmployRequest request) {
        Employer employer = new Employer();

        BeanUtils.copyProperties(request, employer);
        if (request.getGenre().equalsIgnoreCase("MASCULIN")) {
            employer.setGenre(Genre.MASCULIN);
        } else {
            employer.setGenre(Genre.FEMININ);
        }
        employer.setDepartement(departementRepository.findById(request.getDepartement()).get());
        employer.setAgence(agenceREpository.findById(request.getAgence()).get());
        Employer empl = employerRepository.save(employer);
        System.out.println(empl);
        return request;
    }

    public Employer updateEmployer(Long id, Employer employer) {
        Optional<Employer> dep = employerRepository.findById(id);
        if (!dep.isPresent()) {
            throw new IllegalStateException("departement introuvable");
        }
        Employer _empl = dep.get();

        return employerRepository.save(_empl);
    }
}
