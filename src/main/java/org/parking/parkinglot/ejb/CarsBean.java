package org.parking.parkinglot.ejb;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.parking.parkinglot.common.CarDto;
import org.parking.parkinglot.entities.Car;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars()
    {
        LOG.info("find all cars");
        try
        {
            List<CarDto> result;
            TypedQuery<Car> typedQuery = entityManager.createQuery("select c from Car c", Car.class);

            List<Car> cars = typedQuery.getResultList();
            result = cars.stream().map(CarDto::new).toList();

            return result;
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
}
