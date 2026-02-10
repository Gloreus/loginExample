package scbt.rbs.arms.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.Optional;

@Route(value = "/")

@PageTitle("Начало продуктивной работы")
@PermitAll
public class WelcomeView extends Composite<VerticalLayout> {


    public  WelcomeView(AuthenticationContext context){

        getContent().add(new H1("Добро пожаловать, " +
                context.getPrincipalName().orElseThrow())
        );
        getContent().add(new H3("Вам доступны роли:"));

        ListBox<String> listBox = new ListBox<> ();
        listBox.setItems(context.getGrantedRoles());
        listBox.setWidthFull();
        getContent().add(listBox);

    }
}
