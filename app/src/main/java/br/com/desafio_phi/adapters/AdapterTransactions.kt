package br.com.desafio_phi.adapters

import android.graphics.Color
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafio_phi.data.model.TransactionsEntry
import br.com.desafio_phi.utils.CellClickListener
import br.com.desafio_phi.utils.DateFormatter
import com.ipsoft.ph.databinding.TransactionItemBinding


class AdapterTransactions(
    transactions: List<TransactionsEntry>,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<AdapterTransactions.ViewHolder>() {


    private lateinit var transactionBinding: TransactionItemBinding


    private var transactionList: List<TransactionsEntry> = transactions


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        transactionBinding =
            TransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val rootView = transactionBinding.root


        return ViewHolder(rootView)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = transactionList[position]

        val date = DateFormatter.dateFormatter(transactionList[position].createdAt)

        val isPix =
            transactionList[position].tType == "PIXCASHIN" || transactionList[position].tType == "PIXCASHOUT"
        val isPositive =
            transactionList[position].tType == "TRANSFERIN" || transactionList[position].tType == "PIXCASHIN"
                    || transactionList[position].tType == "BANKSLIPCASHIN"

        val newValue = transactionList[position].amount.toString().replace(".", ",")

        holder.pixTag.visibility =
            if (isPix) View.VISIBLE else View.INVISIBLE
        holder.root.setBackgroundColor(if (isPix) Color.LTGRAY else Color.WHITE)
        holder.transactionDate.text = date
        holder.transactionDescription.text = transactionList[position].description
        holder.transactionSender.text = transactionList[position].sender
        holder.transactionValue.text =
            if (isPositive) "R$ $newValue" else "- R$ $newValue"

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
    }

    override fun getItemCount() = transactionList.count()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val root: View = transactionBinding.transactionCard
        val pixTag: TextView = transactionBinding.txtPixTag
        val transactionDescription: TextView = transactionBinding.txtTransactionDescription
        val transactionSender: TextView = transactionBinding.txtTransactionSender
        val transactionValue: TextView = transactionBinding.txtTransactionValue
        val transactionDate: TextView = transactionBinding.txtTransactionDate


    }
}

