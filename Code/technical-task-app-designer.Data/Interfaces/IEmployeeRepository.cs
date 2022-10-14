using technical-task-app-designer.Entities.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace technical-task-app-designer.Data.Interfaces
{
    public interface IEmployeeRepository : IGetAll<Employee>, ISave<Employee>, IUpdate<Employee, string>, IDelete<string>
    {
    }
}
