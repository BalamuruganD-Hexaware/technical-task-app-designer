using NSubstitute;
using technical-task-app-designer.Test.Framework;
using technical-task-app-designer.Business.Services;
using technical-task-app-designer.Data.Interfaces;

namespace technical-task-app-designer.Test.Business.EmployeeServiceSpec
{
    public abstract class UsingEmployeeServiceSpec : SpecFor<EmployeeService>
    {
        protected IEmployeeRepository _employeeRepository;

        public override void Context()
        {
            _employeeRepository = Substitute.For<IEmployeeRepository>();
            subject = new EmployeeService(_employeeRepository);

        }

    }
}
