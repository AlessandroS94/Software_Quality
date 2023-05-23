package it.nnt.data.springrest.business.interfaces;

import it.nnt.data.springrest.model.Corso;

public interface CorsoBO {
    void create(Corso corso);
    void delete(Long id);
}
