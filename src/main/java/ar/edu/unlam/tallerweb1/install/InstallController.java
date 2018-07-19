package ar.edu.unlam.tallerweb1.install;

import ar.edu.unlam.tallerweb1.preparacion.PreparacionResponseDto;
import ar.edu.unlam.tallerweb1.rest.ResponseApi;
import ar.edu.unlam.tallerweb1.rest.ResponseMessages;
import ar.edu.unlam.tallerweb1.util.Install;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class InstallController {

    @Inject
    private CargaService cargaService;

    @RequestMapping(path = "/install", method = RequestMethod.POST, produces = "application/json")
    public ResponseApi instalar(@RequestBody InstallDto instalacionDto){
        if (!instalacionDto.getToken().equals(Install.INSTALL_TOKEN.toString())) {
            ResponseMessages errorMessage = new ResponseMessages(ResponseMessages.UNFORBIDDEN_TEXT);
            errorMessage.setCode("403");
            return errorMessage;
        }
        else {
            try {
                cargaService.cargar();
            } catch (Exception e) {
                ResponseMessages errorMessage = new ResponseMessages(e.getMessage());
                errorMessage.setCode("500");
                return errorMessage;
            }
        }
        return new PreparacionResponseDto();
    }
}
