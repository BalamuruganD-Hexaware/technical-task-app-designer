using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using NSubstitute;
using Shouldly;
using technical-task-app-designer.Entities.Entities;

namespace technical-task-app-designer.Test.Business.EmployeeServiceSpec
{
    public class When_deleting_employee : UsingEmployeeServiceSpec
    {
        private bool _result;

        private string Id = "Khfhuihd";

        public override void Context()
        {
            base.Context();

            _employeeRepository.Delete(Id).Returns(true);
        }
        public override void Because()
        {
            _result = subject.Delete(Id);
        }

        [Test]
        public void Request_is_routed_through_repository()
        {
            _employeeRepository.Received(1).Delete(Id);

        }

        [Test]
        public void Appropriate_result_is_returned()
        {
            _result.ShouldBeOfType<bool>();

            _result.ShouldBe(true);
        }
    }
}
