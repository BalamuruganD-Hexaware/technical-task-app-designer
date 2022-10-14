namespace technical-task-app-designer.Data.Interfaces
{
    public interface IDelete<T>
    {
        bool Delete(T id);
    }
}
