package model.services;

import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {

    private SellerDao dao = DaoFactory.createSellerDao();

    //ALL SELLERS WILL BE TAKEN FROM THE DATABASE - VAI SER PEGO TODOS OS VENDEDORES NO BANCO DE DADOS
    public List<Seller> findAll() {
        return dao.findAll();
    }

    public void saveOrUpdate(Seller obj) {
        /*
        USED TO CHECK WHAT FUNCTION WILL BE DONE AT THE TIME OF CREATING THE ID / NAME O (ID) FIELD
        IT WAS LIKE IT CANNOT BE INSERTED ON THE SCREEN. THEN WHEN YOU REGISTER, YOU DON'T HAVE A ID AND A NEW ONE WILL BE
        INSERTED.
        
        USADO PARA VERIFICAR QUAL FUNÇÃO SERÁ FEITA NA HORA DE CRIAR O CAMPO DE ID/NAME O (ID)
        FICOU COMO NÃO PODE SER INSERIDO NA TELA. ENTÃO QUANDO VOCÊ CADASTRA NÃO TEM ID E ASSIM SERÁ INSERIDO UM NOVO.
         */
        if (obj.getId() == null) {
            dao.insert(obj);
        } else {
            dao.update(obj);
        }
    }

    public void remove(Seller obj) {
        dao.deleteById(obj.getId());
    }
}
