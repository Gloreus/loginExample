package scbt.rbs.arms.views;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.extern.java.Log;

@Route(value = "login")
@AnonymousAllowed
@PageTitle("Вход в систему")
@Log
@Menu(title = "Авторизация", order = 0)
// public class LoginView extends Main implements ComponentEventListener<AbstractLogin.LoginEvent>, BeforeEnterListener{
public class LoginView extends Main implements BeforeEnterObserver{
    private final LoginForm loginForm;

    public LoginView() {

        VerticalLayout layout = new VerticalLayout();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        loginForm = new LoginForm();
        loginForm.setForgotPasswordButtonVisible(false);
        loginForm.setI18n(getI18n());
        loginForm.setAction("login");
        layout.add(loginForm);
        layout.setSizeFull();
        add(layout);
        setSizeFull();
    }

    private LoginI18n getI18n() {
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("АРМ RBS");
        i18nForm.setUsername("Пользователь");
        i18nForm.setPassword("Пароль");
        i18nForm.setSubmit("Войти");
        i18nForm.setForgotPassword("Забыли пароль?");
        i18n.setForm(i18nForm);

        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Ошибка авторизации");
        i18nErrorMessage.setMessage("Неправильный лагин или пароль.");
        i18n.setErrorMessage(i18nErrorMessage);

        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(i18n);
        return i18n;
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        log.info("beforeEnter");
        if (event.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            loginForm.setError(true);
        }

    }
}

