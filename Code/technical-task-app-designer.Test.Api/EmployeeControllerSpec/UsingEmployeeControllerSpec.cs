using NSubstitute;
using technical-task-app-designer.Test.Framework;
using technical-task-app-designer.Api.Controllers;
using technical-task-app-designer.Business.Interfaces;


namespace technical-task-app-designer.Test.Api.EmployeeControllerSpec
{
    public abstract class UsingEmployeeControllerSpec : SpecFor<EmployeeController>
    {
        protected IEmployeeService _employeeService;

        public override void Context()
        {
            _employeeService = Substitute.For<IEmployeeService>();
            subject = new EmployeeController(_employeeService);

        }

    }
}
