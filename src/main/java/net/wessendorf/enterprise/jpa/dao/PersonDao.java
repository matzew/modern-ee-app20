/*
 * Copyright (C) 2010 Matthias Weßendorf.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wessendorf.enterprise.jpa.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.myfaces.extensions.cdi.jpa.api.Transactional;

import net.wessendorf.enterprise.beans.Person;

public class PersonDao
{
  @Transactional
  public void delete(Person entity)
  {
    em.remove(em.merge(entity));
  }

  @Transactional
  public Person persist(Person entity)
  {
    em.persist(entity);
    return entity;
  }

  @Transactional
  public Person update(Person entity)
  {
    return em.merge(entity);
  }

  @SuppressWarnings("unchecked")
  public List<Person> loadAll()
  {
    return em.createQuery("select t from "+Person.class.getSimpleName()+" t").getResultList();  
  }

  public Person loadById(Serializable id)
  {
    return em.find(Person.class, id);
  }

  @SuppressWarnings("unchecked")
  public List<Person> findByLastName(String lastname)
  {
    if(lastname == null)
      return Collections.emptyList();

    Query q = em.createQuery(QUERY_BY_LASTNAME);
    q.setParameter("lastNameParam", lastname.toLowerCase()+"%");
    return q.getResultList();
  }

  @PersistenceContext(unitName = "simpleModernEEApplication")
  protected EntityManager em;

  private final String QUERY_BY_LASTNAME = "select p from Person p where lower(p.lastname) LIKE :lastnameParam";
}
