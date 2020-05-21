import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Nav {
    private Login login;
    private Menu menu;
    private Retrieve retrieve;
    private Operations operation;
    private Connection conn;

    public Nav(){};

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setRetrieve(Retrieve retrieve) {
        this.retrieve = retrieve;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }

    public void initConn(Connection conn) throws SQLException {
        this.conn = conn;
        retrieve.connect(this.conn);
    }

    public Connection getConn() {
        return conn;
    }

    public void goTo(int page){
        if (page == 1){
            login.getPanel().setVisible(true);
            menu.getPanel().setVisible(false);
            retrieve.getPanel().setVisible(false);
            operation.getPanel().setVisible(false);
        }
        if (page == 2){
            login.getPanel().setVisible(false);
            menu.getPanel().setVisible(true);
            retrieve.getPanel().setVisible(false);
            operation.getPanel().setVisible(false);
        }
        if (page == 3){
            login.getPanel().setVisible(false);
            menu.getPanel().setVisible(false);
            retrieve.getPanel().setVisible(true);
            operation.getPanel().setVisible(false);
        }
        if (page == 4){
            login.getPanel().setVisible(false);
            menu.getPanel().setVisible(false);
            retrieve.getPanel().setVisible(false);
            operation.getPanel().setVisible(true);
        }

    }
}
