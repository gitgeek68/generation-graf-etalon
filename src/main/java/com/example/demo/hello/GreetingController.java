package com.example.demo.hello;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ProjectRepository;


@RestController
public class GreetingController 
{
private static final String template = "Hello, %s!";
private final AtomicLong counter = new AtomicLong();
@Autowired
private ProjectRepository projectRepository ;

/*préciser quelle méthode doit être appelée pour une URI donnée*/

/**
 * anotatation RequestMapping permet de declarer le chemin
 * 
 * @param name
 * @return
 */

@RequestMapping("/greeting")
public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
return new Greeting(counter.incrementAndGet(),  String.format(template, name));

}

/**
 *  anotatation RequestMapping permet de declarer le chemin de fichiers
 *  annotation @ResponseBody indique une valeur de retour de méthode.
 *   Projects updateProjects represente la mise à jour de la liste 
 *   Projects avec l ajout  du projet CLOE
 *  la method projectRepository.save savegarde le nouveau projet dans la liste
 * @param CLOE
 * @return
 */
@RequestMapping(value="/projects", method = RequestMethod.PUT)
public @ResponseBody Projects updateProject(@RequestBody Projects CLOE){
;
CLOE = projectRepository.save(CLOE);
 return CLOE;
}

/**
 * method de type Projects projets avec en parametre un entier id
 * creation de proj de type Projects nommé Caramel
 * affichage du projet par la method GetId
 * Liste optionnel projets rechercé dans le projectRepository
 * en utilisant la method findById en index 1
 * si present,affiche le projet avec la method get sino retourne null
 * @param id
 * @return
 */
@RequestMapping("/projects/{id}")
public Projects projects(@PathVariable("id") Integer id)
{
	Projects proj = new Projects("CARAMEL");
	proj = projectRepository.save(proj);
	System.out.println(proj.getId());
	
	Optional<Projects> projets= projectRepository.findById(1);
	if(projets.isPresent())
	{
		return projets.get();	
	}
	else
	{
		return null ;
	}

}

}
