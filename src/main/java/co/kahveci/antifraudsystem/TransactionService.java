package co.kahveci.antifraudsystem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionService {
    public static ResponseEntity<?> checkAmount(Map input)
            throws NumberFormatException, NullPointerException {

        try {
            long amount = Long.parseLong(
                    input.get("amount").toString());

            if (amount <= 0) {
                return new ResponseEntity<>(
                        HttpStatus.BAD_REQUEST);
            }

            if (amount <= 200) {
                return new ResponseEntity<>(
                        Map.of("result", "ACCEPTED"),
                        HttpStatus.OK);
            }

            if (amount <= 1500) {
                return new ResponseEntity<>(
                        Map.of("result", "MANUAL_PROCESSING"),
                        HttpStatus.OK);
            }

            return new ResponseEntity<>(Map.of(
                    "result", "PROHIBITED"),
                    HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST);
        }
    }
}
