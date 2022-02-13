package kollectors.modules.database.entities.base

import org.litote.kmongo.Id

interface DatabaseEntity {

    interface EntityWithId<T: DatabaseEntity> {
        val _id: Id<T>
    }

}