
package br.edu.ifpb.praticas.projeto.factory;

/**
 *
 * @author Edilva
 */
public class FactoryDao {
    
    public static final int DAO_BD = 0;
    
    public static FactoryDaoIF createFactory(int factoryType){
        if(factoryType == DAO_BD){
            return new FactoryDaoBD();
        }
        return null;
    }
}