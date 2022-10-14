using System.Collections.Generic;

namespace technical-task-app-designer.Data.Interfaces
{
    public interface IGetAll<T> where T : class
    {
        IEnumerable<T> GetAll();
    }
}
