package com.midia.scala.membro;

import com.midia.scala.Exerce.ExerceService;
import com.midia.scala.funcao.FuncaoService;
import com.midia.scala.Exerce.Exerce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/membro")
public class MembroController {
    private final MembroService membroService;
    private final ExerceService exerceService;
    private final FuncaoService funcaoService;

    @Autowired
    public MembroController(MembroService membroService, ExerceService exerceService, FuncaoService funcaoService) {
        this.membroService = membroService;
        this.exerceService = exerceService;
        this.funcaoService = funcaoService;
    }

    @GetMapping
    public List<Membro> getMembros() {
        return membroService.getMembros();
    }

    @RequestMapping(value = "/{telefone}", method = RequestMethod.GET)
    public Membro findByTelefone(@PathVariable("telefone") String telefone) {
        return membroService.getMembroByTelefone(telefone);
    }

    @PostMapping("/exerce")
    public void save(@RequestBody Membro membro, @RequestParam(name = "funcao_id") UUID funcaoId) {
        membroService.save(membro);
        exerceService.save(
                new Exerce(
                        membro,
                        funcaoService.findById(funcaoId))
        );
    }
}
