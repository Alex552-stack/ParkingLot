package org.parking.parkinglot.ejb;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.parking.parkinglot.Cars;
import org.parking.parkinglot.common.CarDto;
import org.parking.parkinglot.entities.Car;
import org.parking.parkinglot.entities.User;

import java.util.Collection;
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

    public void createCar(String licensePlate, String parkingSpot, Long userId)
    {
        LOG.info("createCar");

        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);
        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);

        entityManager.persist(car);
    }

    public void updateCar(Long carId ,String licensePlate, String parkingSpot, Long userId){
        LOG.info("updateCar");

        Car car = entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User oldUser = car.getOwner();
        oldUser.getCars().remove(car);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);
    }

    public void deleteCarsById(Collection<Long> carIds)
    {
        LOG.info("DeleteCars");

        for (Long carid : carIds)
        {
            Car car = entityManager.find(Car.class, carIds);
            entityManager.remove(car);
        }
    }
}
