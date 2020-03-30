import { Priority } from '../enums/priority';
import { Status } from '../enums/status';


export interface Todo {
    id: number,
    title: string,
    description: string,
    status: Status,
    creationDate: Date,
    completionDate: Date,
    priority: Priority
}
