package com.example.socialapp.Dao

import com.example.socialapp.Models.UserData
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("users")

    fun addUser(userData: UserData?)
    {
        //user cannot be null, ? checks that only
        userData?.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(userData.uid).set(it)
            }
        }
    }

    fun getUserById(uId: String): Task<DocumentSnapshot>
    {
        return userCollection.document(uId).get()
    }
}