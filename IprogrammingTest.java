package com.example.skclasses;

public class IprogrammingTest {

    // For handling POST request

    function getEmployeeFromRec(req) {
      const employee = {
                first_name: req.body.first_name,
                last_name: req.body.last_name,
                city: city,
                age: age,
                salary: salary,
                department_id: req.body.department_id
      };
        return employee;
    }
    async function post(req, res, next) {
        try {
            let employee = getEmployeeFromRec(req);
            employee = await employees.create(employee);
            res.status(201).json(employee);
        } catch (err) {
            next(err);
        }
    }
    modules.exports.post = post;

// INSERT

const createSql =
            `insert into employees (
            first_name,
            last_name,
            city,
            age,
            salary,
            department_id
            ) values (
            :first_name,
            :last_name,
            :city,
            :age,
            :salary,
            :job_id,
            :department_id
) returning employee_id
    into :employee_id`;
    async function create(emp) {
      const employee = Object.assign({}, emp);
        employee.employee_id = {
                dir: oracledb.BIND_OUT,
                type: oracledb.NUMBER
 }
  const result = await database.simpleExecute(createSql, employee);
        employee.employee_id = result.outBinds.employee_id[0];
        return employee;
    }
    module.exports.create = create;

// UPDTAE

const updateSql =
            `update employees
    set first_name = :first_name,
    last_name = :last_name,
    city = :city,
    age = :age,
    salary = :salary,
    job_id = :job_id,
    salary = :salary,
    department_id = :department_id
    where employee_id = :employee_id`;
    async function update(emp) {
    const employee = Object.assign({}, emp);
    const result = await database.simpleExecute(updateSql, employee);
        if (result.rowsAffected === 1) {
            return employee;
        } else {
            return null;
        }
    }module.exports.update = update;



2—>
    SELECT department_id, COUNT(*)
    FROM emp_details
    GROUP BY department_id;
}
