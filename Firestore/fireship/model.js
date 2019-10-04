import {db} from './config';

// Subcollection Read
const ref = db.collection('posts').doc('postId').collection('tags');

// Bucket Read
const post = db.collection('posts').doc('postId');
const tags = db.collection('tags').doc('postId');

const readIds = async (collection, ids) => {
    const reads = ids.map(id => collection.doc(id).get());
    const result = await Promise.all(reads);
    return result.map(v => v.data());
}