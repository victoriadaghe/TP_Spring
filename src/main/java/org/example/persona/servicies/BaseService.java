package org.example.persona.servicies;

import java.util.List;

public interface BaseService<E> {
    public List<E> findAll() throws Exception;//Trae lista de entidades
    public E findById(Long id) throws Exception;//Traer persona segun ID
    public E save(E entity) throws Exception;//Guarda entidad nueva
    public E update(Long id, E entity) throws Exception;//Actualiza etidad
    public boolean delete(Long id) throws Exception;//Borra entidad

}
