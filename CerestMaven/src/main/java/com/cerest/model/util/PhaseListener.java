package com.cerest.model.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

/**
 *
 * @author moraes
 */
public class PhaseListener implements javax.faces.event.PhaseListener{

    
    //antes da fase
    @Override
    public void beforePhase(PhaseEvent fase) {        
        if(fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Antes da phase"+getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
            
        }
    }

    //depois da fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        if(fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Depois da phase"+getPhaseId());
            Session session=FacesContextUtil.getRequestSession();
            try{
                session.getTransaction().commit();
                
            }catch(Exception e){
                if(session.getTransaction().isActive()){
                    session.getTransaction().rollback();
                }
            }finally{
                session.close();
            }
        }
    }
    
    @Override
    public PhaseId getPhaseId() {
       return PhaseId.ANY_PHASE;
    }
    
}
