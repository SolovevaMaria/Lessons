package ru.top.web.demo.controllers;


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.top.web.demo.models.Movie;
import ru.top.web.demo.models.MovieApiResponse;
import ru.top.web.demo.models.Person;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
public class PersonController {
//    private List<Person> people;
//
//    public PersonController() {
//        people = new ArrayList<>();
//        people.add(new Person("Farid", "Abdullayev", 29));
//        people.add(new Person("Oleq", "Qazmanov", 74));
//        people.add(new Person("Dima", "Bilan", 48));
//    }


    String baseUrl = "http://www.omdbapi.com/";
    String apikey = "266b43cd";

    @GetMapping("/search/{title}")
    public ResponseEntity<?> getMovie(
            @PathVariable String title,
            @RequestParam(required = true) Integer skip,
            @RequestParam(required = true) Integer count
    ) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "?s=" + title + "&apiKey=" + apikey + "&page=";
        ResponseEntity<MovieApiResponse> response = restTemplate.getForEntity(url + 1, MovieApiResponse.class);
        System.out.println("Send # 1");
        List<Movie> arr = new ArrayList<>();

        if (response.getStatusCode().is2xxSuccessful()) {
            MovieApiResponse result = response.getBody();
            arr.addAll(result.search);
            int totalResult = Integer.parseInt(result.totalResults);
            int pages = (int) Math.ceil(totalResult / 10.0);
            int newPage = (int) Math.ceil((count + skip) / 10.0);

            for (int i = 2; i <= newPage; i++) {
                System.out.println("Send # " + i + " => " + url + i);
                response = restTemplate.getForEntity(url + i, MovieApiResponse.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    result = response.getBody();
                    arr.addAll(result.search);
                }
            }
            result.search = arr;

            
            List<Movie> filteredMovies = arr.stream()
                    .skip(skip)
                    .limit(count)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(filteredMovies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //    @GetMapping("/one")
//    public ResponseEntity<?> getMovie(){
//
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://www.omdbapi.com/?s=Hulk&apiKey=266b43cd";
//
////       ResponseEntity response =  restTemplate.exchange(url, HttpMethod.GET,null,String.class);
////       Map response =  restTemplate.getForObject(url, Map.class);
//        ResponseEntity<MovieApiResponse> response =  restTemplate.getForEntity(url, MovieApiResponse.class);
//        MovieApiResponse result = response.getBody();
////       Map<String, Object> result = new TreeMap<>();
////
////       result.put("films",response.get("Movie"));
////       result.put("total",response.get("totalResults"));
////       result.put("resul",response.get("Response"));
//        System.out.println(result);
//        return response;
//    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Person>> getAll() {
//
//        if (people.isEmpty()) return ResponseEntity.noContent().build();
//
//        return ResponseEntity.ok(people);
//    }
//
//
//    @PostMapping("/")
//    public ResponseEntity add(@RequestBody Person person) {
//
//        if (person.getAge() < 18) {
//            return ResponseEntity.badRequest().build();
//        } else {
//            people.add(person);
//            return new ResponseEntity(person, HttpStatus.CREATED);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Person> getById(@PathVariable int id) {
//        Optional<Person> person = people.stream().filter(x -> x.getId() == id).findFirst();
//        if (person.isPresent()) {
//            return ResponseEntity.ok(person.get());
//        } else {
//
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Person> deleteById(@PathVariable int id) {
//        Optional<Person> p = people.stream().filter(x -> x.getId() == id).findFirst();
//        if (p.isPresent()) {
//            people = people.stream().filter(x -> x.getId() != id).toList();
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Person> updateById(@PathVariable int id, @RequestBody Person person) {
//        Optional<Person> result = people.stream().filter(x -> x.getId() == id).findFirst();
//
//        if (result.isPresent()) {
//            Person p = result.get();
//
//            if (person.getAge() != 0) {
//                p.setAge(person.getAge());
//            }
//            if (person.getSurname() != null) {
//                p.setSurname(person.getSurname());
//            }
//            if (person.getName() != null) {
//                p.setName(person.getName());
//            }
//
//            return ResponseEntity.ok(p);
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//}
