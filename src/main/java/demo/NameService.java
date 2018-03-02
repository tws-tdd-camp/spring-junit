package demo;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    public String getName() {
        return "some name";
    }
}
