using MongoDB.Driver;

namespace technical-task-app-designer.Data.Interfaces
{
    public interface IGateway
    {
        IMongoDatabase GetMongoDB();
    }
}
