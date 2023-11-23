package mvc;


import jdbc.dao.Hero;
import jdbc.dao.HeroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import patterns.HeroServiceDao;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MvcController {
    private final HeroServiceDao heroServiceDao;

    @GetMapping
    public String getHeroes(Model model) {
        model.addAttribute("heroes", heroServiceDao.getHeroes());
        return "index";
    }

    @GetMapping("/heroes/{id}")
    public String getHero(@PathVariable("id") long id, Model model) {
        var hero = heroServiceDao.getById(id);
        model.addAttribute("hero", hero);
        return "show";
    }

    @GetMapping("/create")
    public String createHero(Model model) {
        model.addAttribute("hero", HeroDTO.builder().build());
        return "create";
    }

    @PostMapping("/save")
    public String saveHero(@ModelAttribute("hero") Hero heroDTO) {
        heroServiceDao.createHero(heroDTO);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editHero(@PathVariable("id") long id, Model model) {
        var hero = heroServiceDao.getById(id);
        model.addAttribute("hero", hero);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateHero(@ModelAttribute("hero") Hero heroDTO) {
        heroServiceDao.update(heroDTO);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteHero(@PathVariable("id") long id) {
        heroServiceDao.deleteHero(id);
        return "redirect:/";
    }
}
