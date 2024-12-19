package com.singlepointsol.alert

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder? = context?.let { AlertDialog.Builder(it) }
        if (builder != null) {
            builder.setTitle("Erase Data?")
            builder.setMessage("media will be deleted successfully")
            builder.setPositiveButton("erase") {
                    dialog, id -> Toast.makeText(context, "media deleted successfully!", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("cancel") {
                dialog, id ->Toast.makeText(context, "cancel alert", Toast.LENGTH_LONG).show()
            }
        }


        return builder!!.create()

    }
}

