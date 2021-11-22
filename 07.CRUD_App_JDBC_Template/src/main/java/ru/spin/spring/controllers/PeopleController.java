package ru.spin.spring.controllers;

//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.spin.spring.dao.PersonDAO;
import ru.spin.spring.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String indexPeople(Model model) {
        //Получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        //Получим одного человека по id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String showNewPerson(@ModelAttribute("person") Person person) { //Передаем пустые данные в модель (new Person())
        //Покажем форму для добавления нового человека
//    public String showNewPerson(Model model) {
//        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult) {
        //Добавим нового человека с данными из предыдущей формы
        if (bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") int id) {
        //Покажем форму для редактирования
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult) {
        //Сохраним изменения из предыдущей формы
        if (bindingResult.hasErrors())
            return "people/edit";

        personDAO.update(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        //Удалим запись
        System.out.println("Delete");
        personDAO.delete(id);
        return "redirect:/people";
    }
}
