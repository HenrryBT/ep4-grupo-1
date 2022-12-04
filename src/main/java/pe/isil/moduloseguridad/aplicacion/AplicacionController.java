package pe.isil.moduloseguridad.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.shared.BasicResponse;

import java.util.List;

@Controller
@RequestMapping("/app")
public class AplicacionController {
    @Autowired
    private AplicacionService aplicacionService;

    @GetMapping("/")
    public String index(Model model) {
        List<Aplicacion> aplicacion = aplicacionService.getAllApps();
        model.addAttribute("apps", aplicacion);

        return "app/index";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        return "app/create";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Aplicacion aplicacion = aplicacionService.getAppById(id);
        model.addAttribute("app", aplicacion);
        return "app/update";
    }

    @PostMapping("/create")
    public String createUser(Model model, Aplicacion aplicacion) {
        BasicResponse response = aplicacionService.createApp(aplicacion);

        if (response.getCode().equals("200")) {
            return "redirect:/app/";
        } else {
            model.addAttribute("resp", response);
            return "./responseApp";
        }
    }

    @PostMapping("/update")
    public String updateUser(Aplicacion aplicacionToUpdate, Model model) {
        BasicResponse response = aplicacionService.updateApp(aplicacionToUpdate, aplicacionToUpdate.getId());

        if (response.getCode().equals("200")) {
            return "redirect:/app/";
        } else {
            model.addAttribute("resp", response);
            return "./responseApp";
        }
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        aplicacionService.deleteApp(id);
        return "redirect:/app/";
    }
}
