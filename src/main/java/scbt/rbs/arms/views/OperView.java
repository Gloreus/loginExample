package scbt.rbs.arms.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "oper")

@PageTitle("АРМ доступный User")
@RolesAllowed("USER")
@Menu(title = "User АРМ", order = 0)
public class OperView extends Composite<VerticalLayout> {
    public  OperView(){
        getContent().add(new H1("Арм, доступный роли USER") );
    }
}
