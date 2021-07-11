package jbr.springhateoas.resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

  @GetMapping("/all")
  public List<Employee> allEmp() {
    Employee ranjith = new Employee("Ranjith", "Chennai", 1500L);
    Employee kabilan = new Employee("Kabilan", "Bangalore", 1000L);

    return Arrays.asList(ranjith, kabilan);
  }

  @GetMapping(value = "/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
  public List<Employee> allHateoasEmp() {
    Employee ranjith = new Employee("Ranjith", "Chennai", 1500L);
    Map<String, String> map = new HashMap<>();
    map.put("test", "value");
    ranjith.add(ControllerLinkBuilder.linkTo(EmployeeResource.class, map)
        .slash(ranjith.getName()).slash(ranjith.getAddress())
        .withSelfRel());

    ranjith.add(ControllerLinkBuilder.linkTo(EmployeeResource.class)
        .slash(ranjith.getAddress())
        .withRel("address"));

    Employee kabilan = new Employee("Kabilan", "Bangalore", 1000L);
    kabilan.add(ControllerLinkBuilder.linkTo(EmployeeResource.class)
        .slash(kabilan.getName())
        .withSelfRel());

    return Arrays.asList(ranjith, kabilan);
  }
}
