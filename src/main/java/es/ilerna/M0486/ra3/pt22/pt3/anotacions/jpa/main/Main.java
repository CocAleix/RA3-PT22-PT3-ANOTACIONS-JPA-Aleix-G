package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.domain.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcio;

		do {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1) Fase 1: Crear dades de prova");
			System.out.println("2) Fase 2: Treure vehicle de persona");
			System.out.println("3) Fase 3: Actualitzar un vehicle");
			System.out.println("0) Sortir");
			System.out.print("Escull una opció: ");

			opcio = sc.nextInt();
			sc.nextLine();

			switch (opcio) {
			case 1:
				fase1();
				break;
			case 2:
				fase2();
				break;
			case 3:
				fase3();
				break;
			case 0:
				System.out.println("Fins aviat!");
				break;
			default:
				System.out.println("Opció incorrecta.");
			}

		} while (opcio != 0);

		sc.close();
		HibernateSession.getSessionFactory().close();
	}

	private static void fase1() {
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			// PERSONAS
			Student p1 = new Student();
			p1.setName("Anna");
			p1.setSurname("Lopez");
			p1.setPhoneNumber("111.111.111");
			p1.setStudentCode("STU001");

			Student p2 = new Student();
			p2.setName("Jordi");
			p2.setSurname("Martinez");
			p2.setPhoneNumber("222.222.222");
			p2.setStudentCode("STU002");

			Student p3 = new Student();
			p3.setName("Clara");
			p3.setSurname("Sanchez");
			p3.setPhoneNumber("333.333.333");
			p3.setStudentCode("STU003");

			Teacher p4 = new Teacher();
			p4.setName("Joan");
			p4.setSurname("Perez");
			p4.setPhoneNumber("444.444.444");
			p4.setTeacherCode("TEA001");

			Teacher p5 = new Teacher();
			p5.setName("Maria");
			p5.setSurname("Gomez");
			p5.setPhoneNumber("555.555.555");
			p5.setTeacherCode("TEA002");

			Teacher p6 = new Teacher();
			p6.setName("Pere");
			p6.setSurname("Ruiz");
			p6.setPhoneNumber("666.666.666");
			p6.setTeacherCode("TEA003");

			session.save(p1);
			session.save(p2);
			session.save(p3);
			session.save(p4);
			session.save(p5);
			session.save(p6);

			// VEHICLES
			Car v1 = new Car();
			v1.setBrand("Toyota");
			v1.setPrice(18000);
			v1.setYear(2020);
			v1.setDoors(5);
			v1.setSeats(5);
			v1.setOwner(p1);

			Car v2 = new Car();
			v2.setBrand("Ford");
			v2.setPrice(15000);
			v2.setYear(2019);
			v2.setDoors(3);
			v2.setSeats(4);
			v2.setOwner(p5);

			Plane v3 = new Plane();
			v3.setBrand("Cessna");
			v3.setPrice(120000);
			v3.setYear(2015);
			v3.setAutopilot(true);
			v3.setTailNumber("11.111");
			v3.setOwner(p4);

			Plane v4 = new Plane();
			v4.setBrand("Boeing");
			v4.setPrice(900000);
			v4.setYear(2010);
			v4.setAutopilot(false);
			v4.setTailNumber("22.222");
			v4.setOwner(p3);

			Motorcycle v5 = new Motorcycle();
			v5.setBrand("Yamaha");
			v5.setPrice(9000);
			v5.setYear(2021);
			v5.setHasSidecar(false);
			v5.setOwner(p2);

			Motorcycle v6 = new Motorcycle();
			v6.setBrand("Harley-Davidson");
			v6.setPrice(20000);
			v6.setYear(2018);
			v6.setHasSidecar(true);
			v6.setOwner(p6);

			session.save(v1);
			session.save(v2);
			session.save(v3);
			session.save(v4);
			session.save(v5);
			session.save(v6);

			tx.commit();
			System.out.println("Fase 1 completada correctament!");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private static void fase2() {
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			Vehicle v1 = session.get(Vehicle.class, 1L);

			if (v1 != null) {
				v1.setOwner(null);
				session.update(v1);
				System.out.println("Vehicle 1 ara no té propietari.");
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private static void fase3() {
		Session session = HibernateSession.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		try {
			Vehicle v1 = session.get(Vehicle.class, 1L);

			if (v1 != null) {
				v1.setBrand("Seat");
				v1.setPrice(19999);
				v1.setYear(2022);
				v1.setOwner(null);

				session.update(v1);
				System.out.println("Vehicle 1 actualitzat correctament.");
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
