package br.com.desafio_phi.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafio_phi.R
import br.com.desafio_phi.adapters.AdapterTransactions
import br.com.desafio_phi.data.model.TransactionsEntry
import br.com.desafio_phi.data.repository.NetworkModule
import br.com.desafio_phi.ui.view_model.MyViewModel
import br.com.desafio_phi.utils.CellClickListener

class StatementActivity : AppCompatActivity(), CellClickListener {


    private var showBalance: Boolean = true

    private lateinit var viewModel: MyViewModel
    private lateinit var statementBiding: ActivityStatementBinding
    private lateinit var recyclerView: RecyclerView
    private var transactionItemAdapter: AdapterTransactions? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statementBiding = ActivityStatement.inflate(layoutInflater)
        val view = statementBiding.root
        this.setContentView(view)

        initViewModel()
        initObservers()
        initOnClick()

    }

    private fun initRecyclerView(list: List<TransactionsEntry>) {

        recyclerView = statementBiding.rvTransactions
        transactionItemAdapter = AdapterTransactions(list, this)
        recyclerView.adapter = transactionItemAdapter
        recyclerView.setHasFixedSize(true)

        val llm = LinearLayoutManager(this)
        llm.isAutoMeasureEnabled = false
        recyclerView.layoutManager = llm


    }


    private fun initOnClick() {
        val hideBalance = statementBiding.acountChart.imgHideBalance
        hideBalance.setOnClickListener {


            if (showBalance) {
                showBalance = false
                statementBiding.acountChart.txtPersonalBalanceField.visibility = View.INVISIBLE
                hideBalance.setImageResource(R.drawable.closedeye)
                statementBiding.acountChart.divider3.visibility = View.VISIBLE

            } else {
                showBalance = true
                statementBiding.acountChart.txtPersonalBalanceField.visibility = View.VISIBLE
                hideBalance.setImageResource(R.drawable.openeye)
                statementBiding.acountChart.divider3.visibility = View.INVISIBLE


            }


        }
    }

    private fun initViewModel() {

        viewModel = ViewModelProvider(
            this, MyViewModel.MainViewModelFactory(
                NetworkModule
            )
        ).get(MyViewModel::class.java)

    }

    private  fun initObservers() {

        viewModel.getTransactions().observe(this, Observer {


            initRecyclerView(it.statements)


        })

        viewModel.getBalance().observe(this, Observer { balance ->

            statementBiding.acountChart.txtPersonalBalanceField.text =
                "R$ ${balance.amountBalance}".replace(".", ",")

        })

    }

    override fun onCellClickListener(data: TransactionsEntry) {


        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.putExtra("id", data.id)
        startActivity(intent)

    }
}

