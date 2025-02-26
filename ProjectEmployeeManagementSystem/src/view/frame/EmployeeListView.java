package view.frame;

import controller.EmployeeController;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import model.EmployeeModel;

public final class EmployeeListView extends JInternalFrame {

    public EmployeeListView() {
        DefaultTableModel model = new DefaultTableModel(loadEmployeeRowData(), loadEmployeeColumn());
        // creating JTable object
        JTable user_list = new JTable(model);
        // to make table scrollable
        JScrollPane scroll_bar = new JScrollPane(user_list);
        scroll_bar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll_bar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll_bar);
        setMaximizable(true);
        setClosable(true);
        setSize(500, 400);
        setTitle("Add User");
    }

    public Vector<String> loadEmployeeColumn() {
        Vector<String> columns = new Vector<>();
        String columnsNames[] = {"SNo", "Emp No", "First Name", "Middle Name", "Last Name",
            "Gender", "Join Date", "Date of Birth", "Department", "Designation"};
        for (String name : columnsNames) {
            columns.add(name);
        }
        return columns;
    }

    public Vector<Vector<Object>> loadEmployeeRowData() {
        EmployeeController ec = new EmployeeController();

        ArrayList<EmployeeModel> employees = ec.getEmployeeList();
        Vector<Vector<Object>> data = new Vector<>();
        int serial_no = 1;
        for (EmployeeModel em : employees) {
            Vector<Object> row = new Vector<>();
            row.add(serial_no++);
            row.add(em.getEmpNo());
            row.add(em.getFirstName());
            row.add(em.getMiddleName());
            row.add(em.getLastName());
            row.add(em.getGender());
            row.add(em.getJoinDate());
            row.add(em.getDob());
            row.add(em.getDepartment().getDepartmentName());
            row.add(em.getDesignation());
            data.add(row);
        }
        return data;
    }
}
