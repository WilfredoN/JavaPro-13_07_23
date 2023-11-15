package mvc;


import jdbc.dao.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import patterns.HeroServiceDao;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MvcController {
    private final HeroServiceDao heroServiceDao;

    @GetMapping
    public String getHeroes(Model model) {
        model.addAttribute("heroes", "Name");
        model.addAttribute("heroes", heroServiceDao.getHeroes());
        return "index";
    }

    @GetMapping("heroes/{id}")
    public String getHero(@PathVariable("id") long id, Model model) {
        var hero = heroServiceDao.getById(id);
        model.addAttribute("hero", hero);
        return "show";
    }

    @PostMapping("create")
    public String createHero(Hero heroDTO, Model model) {
        model.addAttribute("hero", heroDTO.toBuilder());
        return "redirect:/index";
    }

    @PostMapping("edit/{id}")
    public String editHero(@PathVariable("id") long id, Model model, Hero heroDTO) {
        var baseHero = heroServiceDao.getById(id);
        Hero updatedHero = baseHero.toBuilder()
                .id(heroDTO.getId())
                .name(heroDTO.getName())
                .gender(heroDTO.getGender())
                .eyeColor(heroDTO.getEyeColor())
                .race(heroDTO.getRace())
                .hairColor(heroDTO.getHairColor())
                .height(heroDTO.getHeight())
                .publisher(heroDTO.getPublisher())
                .skinColor(heroDTO.getSkinColor())
                .alignment(heroDTO.getAlignment())
                .weight(heroDTO.getWeight())
                .build();
        heroServiceDao.updateHero(updatedHero);
        model.addAttribute("hero", updatedHero);
        return "redirect:/index";
    }

    @GetMapping("delete/{id}")
    public String deleteHero(@PathVariable("id") long id, Model model) {
        heroServiceDao.deleteHero(id);
        return "redirect:/";
    }
}
