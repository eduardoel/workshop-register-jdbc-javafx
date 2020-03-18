package model.services;

import java.util.List;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();
    //ALL DEPARTMENTS WILL BE TAKEN FROM THE DATABASE - VAI SER PEGO TODOS OS DEPARTAMENTOS NO BANCO DE DADOS
    public List<Department> findAll() {
        return dao.findAll();
    }
}
