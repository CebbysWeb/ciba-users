package lv.cebbys.web.users.service;

import lv.cebbys.web.users.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HtmlBuilder {

    public String userTable(List<User> users) {
        StringBuilder builder = new StringBuilder();
        builder.append("""
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Length</th>
                </tr>
                """
        );
        for (User user : users) {
            builder.append(String.format("""
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    """, user.getName(), user.getLastName(), user.getAge(), user.getLength()
            ));
        }
        return String.format("<html><body><table>%s</table></body></html>", builder);
    }
}
