package co.kahveci.antifraudsystem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/antifraud")
public class Controller {
    @PostMapping("/transaction")
    public ResponseEntity<?> checkTransaction(@RequestBody Map input) {
        return TransactionService.checkAmount(input);
    }
}
