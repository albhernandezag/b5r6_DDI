package com.example.simplespringbootpost;

@RestController
public class PersonRestController {

    @Autowired private PersonService personService;

    @Autowired private PersonRepository personRepository;

    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity < String > persistPerson(@RequestBody PersonDTO person) {
        if (personService.isValid(person)) {
            personRepository.persist(person);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
