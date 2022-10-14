using System.Collections.Generic;
using technical-task-app-designer.Business.Interfaces;
using technical-task-app-designer.Entities.Entities;
using Microsoft.AspNetCore.Mvc;

namespace technical-task-app-designer.Api.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class EmployeeController : ControllerBase
    {
        IEmployeeService _EmployeeService;
        public EmployeeController(IEmployeeService EmployeeService)
        {
            _EmployeeService = EmployeeService;
        }

        // GET: api/Employee
        [HttpGet]
        public ActionResult<IEnumerable<Employee>> Get()
        {
            return Ok(_EmployeeService.GetAll());
        }

        [HttpPost]
        public ActionResult<Employee> Save(Employee Employee)
        {
            return Ok(_EmployeeService.Save(Employee));

        }

        [HttpPut("{id}")]
        public ActionResult<Employee> Update([FromRoute] string id, Employee Employee)
        {
            return Ok(_EmployeeService.Update(id, Employee));

        }

        [HttpDelete("{id}")]
        public ActionResult<bool> Delete([FromRoute] string id)
        {
            return Ok(_EmployeeService.Delete(id));

        }


    }
}
