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
package net.wessendorf.enterprise.faces;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.wessendorf.enterprise.beans.Person;
import net.wessendorf.enterprise.service.PersonService;

@Named("allPersons")
@RequestScoped
public class AllPersonsController
{
  @Inject private PersonService service;

  private Person toDelete;
  
  public List<Person> getPersons()
  {
    return service.findAllPersons();
  }

  public void setToDelete(Person toDelete)
  {
    this.toDelete = toDelete;
  }

  public Person getToDelete()
  {
    return toDelete;
  }
  
  public String delete()
  {
    service.removePerson(toDelete);
    return null;
  }

}
