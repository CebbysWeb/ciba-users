package lv.cebbys.web.users.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private int id;
    private Byte age;
    private Integer length;
    private String name;
    private String lastName;
}
