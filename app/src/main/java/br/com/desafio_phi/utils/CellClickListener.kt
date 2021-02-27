package br.com.desafio_phi.utils

import br.com.desafio_phi.data.model.TransactionsEntry


interface CellClickListener {
    fun onCellClickListener(data: TransactionsEntry)
}